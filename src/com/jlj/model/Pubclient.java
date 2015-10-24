package com.jlj.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pubclient entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pubclient", catalog = "wsp")
public class Pubclient implements java.io.Serializable {

	// Fields

	private Integer id;
	private Dspuser dspuser;
	private String publicname;
	private String publicno;
	private String publicaccount;
	private String url;
	private String token;
	private String encodingaeskey;
	private Integer accounttype;
	private String appid;
	private String appsecret;
	private String accessToken;
	private Date createdate;
	private Date deaddate;
	private Integer protype;
	private String comtel;
	private String navurl;
	private String enterurl;
	private String imgurl;

	// Constructors

	/** default constructor */
	public Pubclient() {
	}

	/** full constructor */
	public Pubclient(Dspuser dspuser, String publicname, String publicno,
			String publicaccount, String url, String token,String encodingaeskey,
			Integer accounttype, String appid, String appsecret,
			String accessToken, Date createdate, Date deaddate,
			Integer protype, String comtel, String navurl, String enterurl,
			String imgurl) {
		this.dspuser = dspuser;
		this.publicname = publicname;
		this.publicno = publicno;
		this.publicaccount = publicaccount;
		this.url = url;
		this.token = token;
		this.encodingaeskey = encodingaeskey;
		this.accounttype = accounttype;
		this.appid = appid;
		this.appsecret = appsecret;
		this.accessToken = accessToken;
		this.createdate = createdate;
		this.deaddate = deaddate;
		this.protype = protype;
		this.comtel = comtel;
		this.navurl = navurl;
		this.enterurl = enterurl;
		this.imgurl = imgurl;
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
	@JoinColumn(name = "dspuserid")
	public Dspuser getDspuser() {
		return this.dspuser;
	}

	public void setDspuser(Dspuser dspuser) {
		this.dspuser = dspuser;
	}

	@Column(name = "publicname", length = 50)
	public String getPublicname() {
		return this.publicname;
	}

	public void setPublicname(String publicname) {
		this.publicname = publicname;
	}

	@Column(name = "publicno", length = 20)
	public String getPublicno() {
		return this.publicno;
	}

	public void setPublicno(String publicno) {
		this.publicno = publicno;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@Column(name = "url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "token", length = 32)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "accounttype")
	public Integer getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(Integer accounttype) {
		this.accounttype = accounttype;
	}

	@Column(name = "appid", length = 50)
	public String getAppid() {
		return this.appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	@Column(name = "appsecret", length = 50)
	public String getAppsecret() {
		return this.appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	@Column(name = "access_token", length = 300)
	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createdate", length = 10)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "deaddate", length = 10)
	public Date getDeaddate() {
		return this.deaddate;
	}

	public void setDeaddate(Date deaddate) {
		this.deaddate = deaddate;
	}

	@Column(name = "protype")
	public Integer getProtype() {
		return this.protype;
	}

	public void setProtype(Integer protype) {
		this.protype = protype;
	}

	@Column(name = "comtel", length = 30)
	public String getComtel() {
		return this.comtel;
	}

	public void setComtel(String comtel) {
		this.comtel = comtel;
	}

	@Column(name = "navurl")
	public String getNavurl() {
		return this.navurl;
	}

	public void setNavurl(String navurl) {
		this.navurl = navurl;
	}

	@Column(name = "enterurl")
	public String getEnterurl() {
		return this.enterurl;
	}

	public void setEnterurl(String enterurl) {
		this.enterurl = enterurl;
	}

	@Column(name = "imgurl")
	public String getImgurl() {
		return this.imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Column(name = "encodingaeskey", length = 43)
	public String getEncodingaeskey() {
		return encodingaeskey;
	}

	public void setEncodingaeskey(String encodingaeskey) {
		this.encodingaeskey = encodingaeskey;
	}
	
	

}