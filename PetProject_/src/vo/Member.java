package vo; 
//value object : 일관적으로 필드랑 get, setter를 묶어 놓은 패키지. 
//DTO : data Transfer Object
//bin, 셋다 같은 의미. 

public class Member {
	private String id;
	private String password;
	private String name;
	private int age;
	private String email;
	private String gender;
	
	//각각 필드값을 출력하는 메소드
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + ", email=" + email
				+ ", gender=" + gender + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
