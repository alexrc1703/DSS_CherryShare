package APP;

import DB.UserDAO;

public class Facade {
    private UserDAO userDao;

    public Facade(){
        userDao = new UserDAO();
    };

    public boolean login(String email, String password){
        try {
            User u = userDao.get(email);
            return u.getPassword().equals(password);

        }catch(Exception e){throw new NullPointerException(e.getMessage());}
    }

    public void addUser(User u){
        this.userDao.put(u);
    }

    public void populate(){

        //User v = userdao.get("manuel");
        //String s = v.getName();
        System.out.println("ola");

    }
}
