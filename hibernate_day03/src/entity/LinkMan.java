package entity;

public class LinkMan {
	//id
	private Integer lkm_id;
	//姓名
	private String lkm_name;
	//性别
	private String lkm_gender;
	//电话
	private String lkm_Phone;
	
	//在联系人的实体类里面表示所属客户
	//一个联系人只属于一个客户
	private Customer customer;
	
	public LinkMan(){
		
	}
	
	public LinkMan(String lkm_name, String lkm_gender, String lkm_Phone) {
		super();
		this.lkm_name = lkm_name;
		this.lkm_gender = lkm_gender;
		this.lkm_Phone = lkm_Phone;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getLkm_id() {
		return lkm_id;
	}
	public void setLkm_id(Integer lkm_id) {
		this.lkm_id = lkm_id;
	}
	public String getLkm_name() {
		return lkm_name;
	}
	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}
	public String getLkm_gender() {
		return lkm_gender;
	}
	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}
	public String getLkm_Phone() {
		return lkm_Phone;
	}
	public void setLkm_Phone(String lkm_Phone) {
		this.lkm_Phone = lkm_Phone;
	}
	
}
