public class gerenciar {
    private ArrayList<User> usuarios;

    public gereciador(){
        usuarios = new ArrayList<>();
    }

    public String add (String nome, String email) {

        usuarios.add(new User(nome, email));
        return "cabaco add";
    }

    public String listarUser(){
        String ret="";

        for (User u:usuarios){
            ret +="->"=u.getNome()=";"+u.getEmaill(+"/n");
        }
    }
}
