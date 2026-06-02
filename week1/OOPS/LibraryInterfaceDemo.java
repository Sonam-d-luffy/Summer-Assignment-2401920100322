public class LibraryInterfaceDemo {
    public static void main(String[] args) {
        KidUser kid = new  KidUser();
        AdultUser adult = new  AdultUser();
        //Kid User
        kid.age = 10;
        kid.registerAccount();
        kid.age = 18;
        kid.registerAccount();
        kid.bookType = "Kids";
        kid.requestBook();
        kid.bookType = "Fiction";
        kid.requestBook();

        //Adult tUser
        adult.age = 5;
        adult.registerAccount();
        adult.age = 23;
        adult.registerAccount();
        adult.bookType = "Kids";
        adult.requestBook();
        adult.bookType = "Fiction";
        adult.requestBook();
    }
}
