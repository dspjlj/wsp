package com.jlj.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Wscproduct entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wscproduct", catalog = "wsp")
public class Wscproduct implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wsctype wsctype;
	private String name;
	private Integer protype;
	private String imageshort;
	private String imageurl1;
	private String imageurl2;
	private String imageurl3;
	private Float price;
	private Float discount;
	private Integer num;
	private String detail;
	private String proargs;
	private String relativeids;
	private Date createtime;
	private Integer ison;
	private Integer orderid;
	private Set<Wscproxgpz> wscproxgpzs = new HashSet<Wscproxgpz>(0);
	private Set<Wscprocollect> wscprocollects = new HashSet<Wscprocollect>(0);
	private Set<Wscprorecommend> wscprorecommends = new HashSet<Wscprorecommend>(
			0);
	private Set<Wscorderpro> wscorderpros = new HashSet<Wscorderpro>(0);
	private Set<Wscprocomment> wscprocomments = new HashSet<Wscprocomment>(0);
	private Set<Wscproarg> wscproargs = new HashSet<Wscproarg>(0);
	private Set<Wscprodiscount> wscprodiscounts = new HashSet<Wscprodiscount>(0);

	// Constructors

	/** default constructor */
	public Wscproduct() {
	}

	/** full constructor */
	public Wscproduct(Wsctype wsctype, String name, Integer protype,
			String imageshort, String imageurl1, String imageurl2,
			String imageurl3, Float price, Float discount, Integer num,
			String detail, String proargs, String relativeids, Date createtime,
			Integer ison, Integer orderid, Set<Wscproxgpz> wscproxgpzs,
			Set<Wscprocollect> wscprocollects,
			Set<Wscprorecommend> wscprorecommends,
			Set<Wscorderpro> wscorderpros, Set<Wscprocomment> wscprocomments,
			Set<Wscproarg> wscproargs, Set<Wscprodiscount> wscprodiscounts) {
		this.wsctype = wsctype;
		this.name = name;
		this.protype = protype;
		this.imageshort = imageshort;
		this.imageurl1 = imageurl1;
		this.imageurl2 = imageurl2;
		this.imageurl3 = imageurl3;
		this.price = price;
		this.discount = discount;
		this.num = num;
		this.detail = detail;
		this.proargs = proargs;
		this.relativeids = relativeids;
		this.createtime = createtime;
		this.ison = ison;
		this.orderid = orderid;
		this.wscproxgpzs = wscproxgpzs;
		this.wscprocollects = wscprocollects;
		this.wscprorecommends = wscprorecommends;
		this.wscorderpros = wscorderpros;
		this.wscprocomments = wscprocomments;
		this.wscproargs = wscproargs;
		this.wscprodiscounts = wscprodiscounts;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wsctypeid")
	public Wsctype getWsctype() {
		return this.wsctype;
	}

	public void setWsctype(Wsctype wsctype) {
		this.wsctype = wsctype;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "protype")
	public Integer getProtype() {
		return this.protype;
	}

	public void setProtype(Integer protype) {
		this.protype = protype;
	}

	@Column(name = "imageshort", length = 100)
	public String getImageshort() {
		return this.imageshort;
	}

	public void setImageshort(String imageshort) {
		this.imageshort = imageshort;
	}

	@Column(name = "imageurl1", length = 100)
	public String getImageurl1() {
		return this.imageurl1;
	}

	public void setImageurl1(String imageurl1) {
		this.imageurl1 = imageurl1;
	}

	@Column(name = "imageurl2", length = 100)
	public String getImageurl2() {
		return this.imageurl2;
	}

	public void setImageurl2(String imageurl2) {
		this.imageurl2 = imageurl2;
	}

	@Column(name = "imageurl3", length = 100)
	public String getImageurl3() {
		return this.imageurl3;
	}

	public void setImageurl3(String imageurl3) {
		this.imageurl3 = imageurl3;
	}

	@Column(name = "price", precision = 12, scale = 0)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "discount", precision = 12, scale = 0)
	public Float getDiscount() {
		return this.discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "detail", length = 65535)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "proargs", length = 65535)
	public String getProargs() {
		return this.proargs;
	}

	public void setProargs(String proargs) {
		this.proargs = proargs;
	}

	@Column(name = "relativeids", length = 100)
	public String getRelativeids() {
		return this.relativeids;
	}

	public void setRelativeids(String relativeids) {
		this.relativeids = relativeids;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createtime", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "ison")
	public Integer getIson() {
		return this.ison;
	}

	public void setIson(Integer ison) {
		this.ison = ison;
	}

	@Column(name = "orderid")
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscproduct")
	public Set<Wscproxgpz> getWscproxgpzs() {
		return this.wscproxgpzs;
	}

	public void setWscproxgpzs(Set<Wscproxgpz> wscproxgpzs) {
		this.wscproxgpzs = wscproxgpzs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscproduct")
	public Set<Wscprocollect> getWscprocollects() {
		return this.wscprocollects;
	}

	public void setWscprocollects(Set<Wscprocollect> wscprocollects) {
		this.wscprocollects = wscprocollects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscproduct")
	public Set<Wscprorecommend> getWscprorecommends() {
		return this.wscprorecommends;
	}

	public void setWscprorecommends(Set<Wscprorecommend> wscprorecommends) {
		this.wscprorecommends = wscprorecommends;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscproduct")
	public Set<Wscorderpro> getWscorderpros() {
		return this.wscorderpros;
	}

	public void setWscorderpros(Set<Wscorderpro> wscorderpros) {
		this.wscorderpros = wscorderpros;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscproduct")
	public Set<Wscprocomment> getWscprocomments() {
		return this.wscprocomments;
	}

	public void setWscprocomments(Set<Wscprocomment> wscprocomments) {
		this.wscprocomments = wscprocomments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscproduct")
	public Set<Wscproarg> getWscproargs() {
		return this.wscproargs;
	}

	public void setWscproargs(Set<Wscproarg> wscproargs) {
		this.wscproargs = wscproargs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscproduct")
	public Set<Wscprodiscount> getWscprodiscounts() {
		return this.wscprodiscounts;
	}

	public void setWscprodiscounts(Set<Wscprodiscount> wscprodiscounts) {
		this.wscprodiscounts = wscprodiscounts;
	}

}