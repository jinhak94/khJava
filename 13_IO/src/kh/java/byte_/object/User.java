package kh.java.byte_.object;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	/**
	 * 클래스는 패키지와 클래스를 통해서 이름으로 관리하고, 
	 * 또 한 가지, 내부적으로 특정 클래스에 Unique ID를 통해 구별한다.
	 * 필드 정보를 통해서 Unique ID를 생성하는데, 이를 따로 선언하지 않아도
	 * 저절로 생성이 되긴 하지만, 필드 정보가 변경되는 경우에,
	 * 다른 객체들간의 송수신 과정에 문제가 생길 수 있다.
	 * 따라서 1L이라고 놓으면 패키지, 클래스명으로 UID를 고정하겠다 라고 지정.
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;
	//  transient는 Serialize하는 과정에 제외하고 싶은 경우 선언하는 키워드입니다.
	//  쓰기 작업을 할 때 일어납니다.
	//  패스워드와 같은 보안정보가 직렬화(Serialize) 과정에서 제외하고 싶은 경우에 적용합니다.
	//  다양한 이유로 데이터를 전송을 하고 싶지 않을 때 선언할 수 있습니다.
	private transient String password;
	private String userName;
	private Date regDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String password, String userName, Date regDate) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.regDate = regDate;
	}
	
	   @Override
	   public String toString() {
	      return "User [userId=" + userId + ", password=" + 
	   password + ", userName=" + userName + ", regDate=" + 
	    		  regDate + "]";
	   }

}
