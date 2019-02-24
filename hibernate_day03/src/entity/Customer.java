package entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	//id
	private Integer cid;
	//����
	private String custName;
	//����
	private String custLevel;
	//��Դ
	private String custSource;
	//�绰
	private String custPhone;
	//�ֻ�
	private String custMobile;
	
	//�ڿͻ�ʵ���������ʾ�����ϵ��  һ���ͻ������ϵ��
	//��hibernate���ü��ϱ�ʾ������ݣ���set(�������ظ�Ԫ��)����
	Set<LinkMan> setLinkMan = new HashSet<>();
	
	public Customer(){
		
	}
	
	public Customer(String custName, String custLevel, String custSource, String custPhone,
			String custMobile) {
		super();
		
		this.custName = custName;
		this.custLevel = custLevel;
		this.custSource = custSource;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
	}
	public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}
	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	
	
}
