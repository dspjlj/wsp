/// <reference path="../../public/jquery-1.10.0.js" />
/// <reference path="../../public/jquery.mobile-1.3.1.js" />

//1.wb_banner
(function (window, $, undefined) {

    $.widget('mobile.wb_banner', $.mobile.widget, {
        options: {

        },
        refresh: function () {
            var self = this,
			$el = self.element,
            $parent = $el.parent();
            $box = $('.wb_banner-box', $el);
            list = $box.children('[wb_img]'),
            list_count = list.length;

            list.width($parent.width());
            $box.width(100 * list_count+'%').css('left', -$el.data('__currIndex') * $parent.width());
        },
        _create: function () {
            var self = this,
			$el = self.element,
            list = $el.children('[wb_img]'),
            list_count = list.length,
            $parent = $el.parent();

            $el.addClass('wb_banner');
            var boxWidth = 0, boxHeight = 0;

            var $box = $('<div class="wb_banner-box"></div>').appendTo($el);
            var $toolbar= $('<div class="wb_banner-toolbar"></div>');
            list.each(function () {
                var $this = $(this);
                $this.addClass('wb_banner-item').css({
                    'background-image': 'url(' + this.getAttribute('wb_img') + ')',
                    'width': ((1 / list_count * 100)) + '%'
            	}).html($.trim($this.html())=='' ? '' : ( '<div class="wb_banner-item-title">' + $this.html() + '</div>')).appendTo($box);
            
                $toolbar.append('<span class="wb_banner-toolitem"></span>');
            });

            var flganimate = false;

            $el.data('__currIndex',0)
            
            $box.width(100 * list_count + '%');

            if (list_count>1) {//超过1个图片
                //添加工具条
                $toolbar.appendTo($el);
                //绑定事件
                $el.on({
                    'swipeleft': function () {
                        if (!flganimate && $el.data('__currIndex') < (list_count - 1)) {
                            selectedIndex($el.data('__currIndex')+1);
                        }
                    },
                    'swiperight': function () {
                        if (!flganimate && $el.data('__currIndex') > 0) {
			    selectedIndex($el.data('__currIndex') - 1);
                        }
                    }
                })
                //选中第一个
                selectedIndex($el.data('__currIndex'));
            };

            $el.on('tap', '[wb_img]', null, function () {
                var href = this.getAttribute('wb_link');
                if (href) {
                    if ($.mobile.path.isAbsoluteUrl(href)) {
                        window.location.href = href;
                    } else {
                        $.mobile.changePage(href);
                    }
                }
            });


            //this.refresh();

            $(document).bind("orientationchange", function (e) {
                self.refresh();
            });


            function selectedIndex(index) {
		$el.data('__currIndex', index);
		moveLeft(-$el.data('__currIndex') * $parent.width());
                $($toolbar.children().removeClass('selected')[index]).addClass('selected');
            }

            function moveLeft(toLeft) {
                flganimate = true;
                $box.animate({
                    'left' : toLeft+'px'
                }, 220, 'linear', function () {
                    flganimate = false;
                });
            }
	    
	    function autoScroll(){
		var cindex = $el.data('__currIndex');
		cindex++;
		if(cindex>=list_count){
		    cindex = 0;
		}
		if(!flganimate){
		    selectedIndex(cindex);
		}
		window.setTimeout(autoScroll,3500);
	    }
	    
	    autoScroll();
        }
    });

    $(document).bind("pagecreate", function (e) {
        return $(':jqmData(role=\'wb_banner\')', e.target).wb_banner();
    });
})(window, jQuery, undefined);


//2.wb_list
(function (window, $, undefined) {
    $.widget('mobile.wb_listview', $.mobile.widget, {
        options: {

        },
        _create: function () {
            var self = this,
			$el = self.element,
            list = $el.children(),
            list_count = list.length,
            $parent = $el.parent();

            list.each(function () {
                var $this = $(this),
                    text = $this.text(),
                    summary = $this.attr('wb_summary'),
                    bigimg = $this.attr('wb_bigimg'),
                    smallimg = $this.attr('wb_smallimg'),
                    href = $this.attr('wb_link')
                    html = '';

                	html += '<a class="ui-btn-inner ui-link" onclick="window.location.href=\''+ href +'\'">';
                    html += '<div class="wb_listview-img" style="background-image:url(' + smallimg + ')">&nbsp;</div>';
                    html += '<div class="wb_listview-line">';
                    html += ' <div class="wb_listview-text">' + text + '</div>';
                    html += '<div class="wb_listview-summary">' + summary + '</div>';
                    html += '</div>';
                    html += '</div>';
                    html += '</a>';
                    html += '<div class="icon ui-icon ui-icon-arrow-r ui-icon-shadow"></div>';


                $this.addClass('wb_listview-item ui-btn ui-btn-up-c').html('').append(html);

            });

        }
    });

    $(document).bind("pagecreate", function (e) {
        return $(':jqmData(role=\'wb_listview\')', e.target).wb_listview();
    });
})(window, jQuery, undefined);

/*
<div class="wb_listview-item ui-btn ui-btn-up-c" wb_bigimg="data/4.jpg" wb_smallimg="data/4_s.jpg" wb_link="detail.html" wb_summary="这里是企业的简单介绍内链">
    <a class="ui-btn-inner ui-link" href="#">
        <div class="wb_listview-item-inner">
            <div class="wb_listview-img">&nbsp;</div>
            <div class="wb_listview-line">
                <div class="wb_listview-text">企业简介</div>
                <div class="wb_listview-summary">这里是关于企业的介绍</div>
            </div>
        </div>
    </a>
    <div class="icon ui-icon ui-icon-arrow-r ui-icon-shadow"></div>
</div>
*/

//3.wb_easycall-handler
(function (window, $, undefined) {

    //构造handler
    function createHandler($easycall) {
        var list_count = $easycall.children().length;
        if (list_count > 0) {
            var $doc = $(document),
            fn_showEasyCall = function () {
                $easycall.css('zIndex', $handler.css('zIndex') - 1).fadeIn();
                $EasyCall_MaskLayer.css('zIndex', $easycall.css('zIndex') - 1).show();
                $Handler_MaskLayer.hide();
                $handler.hide();
            },
            fn_hideEasyCall = function () {
                $easycall.fadeOut(function () {
                    $EasyCall_MaskLayer.hide();
                    $handler.show();
                });
            };

            $easycall.bind('tap', fn_hideEasyCall);

            var $handler = $('.wb_easycall-handler').bind('vmousedown', function (e) {
                var $this = $(this);
                $this.addClass('active');
                startX = e.screenX;
                startY = e.screenY;
                startLeft = parseInt($this.css('left'));
                startTop = parseInt($this.css('top'));
                $doc.bind('vmousemove', fn_move);
                $doc.bind('vmouseup', fn_up);
                fn_showEasyCall();
            });

            var $Handler_MaskLayer = $('<div class="ui-popup-screen"></div>').hide().appendTo($handler.parent());
            var $EasyCall_MaskLayer = $('<div class="ui-popup-screen"></div>').hide().appendTo($handler.parent());

            var diff = 0;

            var fn_fix = function (diff) {
                if (diff > 0) {
                    $handler.animate({
                        'left': $doc.width() - $handler.width()
                    }, 220, 'swing', function () {
                        $Handler_MaskLayer.hide();
                    });
                }
                else {
                    $handler.animate({
                        'left': 0
                    }, 220, 'swing', function () {
                        $Handler_MaskLayer.hide();
                    });
                }
            };

            var fn_move = function (e) {
                $Handler_MaskLayer.css('zIndex', $handler.css('zIndex') - 2).show();
                diff = e.screenX - startX;
                $handler.css({
                    'left': startLeft + e.screenX - startX,
                });

                if (Math.abs(diff) > 20) {
                    fn_up();
                }
            };
            var fn_up = function (e) {
                $doc.unbind('vmousemove', fn_move);
                $doc.unbind('vmouseup', fn_up);
                fn_fix(diff);
            };

            var startX = 0, startY = 0, startLeft = 0, startTop = 0;
        }
    }

    //初始化Hander
    function initHander($handler, $easycall, $Handler_MaskLayer, $EasyCall_MaskLayer) {
        var $doc = $(document), startX = 0, startY = 0, startLeft = 0, startTop = 0, flgDraging = false, diff = 0,
            //自动停靠
            fn_fix = function (diff) {
                if (diff > 0) {
                    $handler.animate({
                        'left': $doc.width() - $handler.width()
                    }, 220, 'swing', fn_fix_end);
                }
                else {
                    $handler.animate({
                        'left': 0
                    }, 220, 'swing', fn_fix_end);
                }
            },
            fn_fix_end = function () {
                flgDraging = false;
                $Handler_MaskLayer.hide();
            },
            //拖动进行
            //fn_running = function (e) {
            //    diff = e.screenX - startX;
            //    $Handler_MaskLayer.show();
            //    $handler.css({
            //        'left': startLeft + diff,
            //        'top': startTop + (e.screenY - startY),
            //    });

            //    if (Math.abs(diff) > 100) {
            //        fn_end();
            //    }
            //    return false;
            //},
            //拖动结束
            fn_end = function (e) {
                $handler.removeClass('active');
                $doc.unbind('vmousemove', fn_running);
                $doc.unbind('vmouseup', fn_end);
                var pos = $handler.offset();
                $handler.css({
                    'position': 'fixed',
                    'left': pos.left-$(document).scrollLeft(),
                    'top': pos.top - $(document).scrollTop(),
                });


                fn_fix(diff);
                flgDraging = false;
            },

            //拖动开始
            fn_start = function (e) {
                //var $this = $(this), pos = $this.offset();
                //$this.addClass('active').css({
                //    'position': 'absolute',
                //    'left': pos.left,
                //    'top': pos.top,
                //});
                //startX = e.screenX;
                //startY = e.screenY;
                //startLeft = parseInt($this.css('left'));
                //startTop = parseInt($this.css('top'));
                //$doc.bind('vmousemove', fn_running);
                //$doc.bind('vmouseup', fn_end);
                //flgDraging = true;
            },

            //点击handler，显示快捷按钮列表
            fn_handle_tap = function () {
                if (!flgDraging) {
                    $EasyCall_MaskLayer.show();
                    $easycall.fadeIn();
                }
                return false;
            };

        var list = $easycall.children('[wb_type]'), list_count = list.length, firstItem = $(list[0]);

        //1.设置$handler图标，用第一作为图标
        //$handler.css('background', $('.icon',firstItem).css('background'));
        var $icon = $('.icon', firstItem);
        $handler.css({
            'background-image': $icon.css('background-image'),
            'background-repeat': $icon.css('background-repeat'),
            'background-position': $icon.css('background-position')
        })
        //2.拖动逻辑
        $handler.bind('vmousedown', fn_start);
        //3.点击逻辑
        if (list_count === 1) {//只有一个快捷拨号，则不出现列表，直接点击操作
            $handler.append('<a style="display:block;position:absolute;width:100%;height:100%;top:0;left:0;" href="' + firstItem.attr('wb_link') + '">&nbsp;</a>');
        } else {//2个和2个以上，显示快捷列表面板
            $EasyCall_MaskLayer.bind('tap', function () {
                $easycall.fadeOut(function () {
                    $EasyCall_MaskLayer.hide();
                });
            });

            $easycall.bind('tap', function () {
                $easycall.fadeOut(function () {
                    $EasyCall_MaskLayer.hide();
                });
            });

            $handler.bind('tap', fn_handle_tap);
        }
    }


    $.widget('mobile.wb_easycall', $.mobile.widget, {
        options: {

        },
        _create: function () {
            var self = this,
			$el = self.element,
            list = $el.children(),
            list_count = list.length,
            $parent = $el.parent(),
            $handler,
            $Handler_MaskLayer,
            $EasyCall_MaskLayer;

            $el.css('zIndex',9000).append('<div class="bg"></div>').addClass('wb_easycall ' + 'child' + list_count).hide();

            list.each(function (index, item) {
                var $item = $(item);
                    $item.addClass('wb_easycall-item no' + (index + 1) + ' ' + item.getAttribute('wb_type'))
                    .html('<a href="' + item.getAttribute('wb_link') + '"><div class="icon"></div><div class="text">' + $item.html() + '</div></a>');
            });

            if (list_count > 0) {
                $handler = $('<div class="wb_easycall-handler"></div>').css('zIndex', 8000).appendTo($parent);
                $Handler_MaskLayer = $('<div class="ui-popup-screen"></div>').css('zIndex', 7999).hide().appendTo($handler.parent());
                $EasyCall_MaskLayer = $('<div class="ui-popup-screen"></div>').css('zIndex', 8999).hide().appendTo($handler.parent());

                initHander($handler, $el, $Handler_MaskLayer, $EasyCall_MaskLayer);
            }
        }
    });

    $(document).bind('pagecreate', function (e) {
        return $(':jqmData(role=\'wb_easycall\')', e.target).wb_easycall();
    });
})(window, jQuery, undefined);

/*
        <div data-role="wb_easycall" class="wb_easycall child3">
            <div class="bg"></div>
            <div class="wb_easycall-item type0 no1" wb_link="tel:1222222">
                <a href="tel:138">
                    <div class="icon"></div>
                    <div class="text">一键拨号1</div>
                </a>
            </div>
        </div>

*/