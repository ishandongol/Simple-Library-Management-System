public abstract class Authentication {
    public static boolean authenticate(User currentUser) {
        if(currentUser instanceof Admin){
            return true;
        }
        return false;
    }
}
