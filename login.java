public class login{

	public static Boolean userlogin(String userName, String password){
		if(userName.equals(user.userName) && password.equals(user.password){
			return true;
		}
		else{
		return false;
		}
	}

	public static Boolean userlogin(String userName, int PIN){
		if(userName.equals(user.userName) && PIN == user.PIN){
			return true;
		}
		else{
		return false;
		}
	}
}
