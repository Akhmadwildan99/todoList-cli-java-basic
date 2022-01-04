import java.util.ArrayList;

public class JavaTodoList {
    public static String[] model = new String[10];

    public static void main(String[] args) {
        testRemoveTodoList();
    }

    /**
     * method show todo list;
     */
    public static void showTodoList() {
        for (var i = 0; i < model.length; i++){
            if(model[i] != null){
                System.out.println(i + 1 + ". " + model[i]);
            }
        }
    }

    // test show todo list
    public static void testShowTodoList(){
        model[0] = "satu";
        model[1] = "dua";
        model[2] = "tiga";

        showTodoList();
    }

    /**
     *
     *  method add todo list;
     */
    public static void addTodoList(String todo){
        var isFull = true;
        for (var i = 0; i < model.length; i++){
            //Jika array masih ada yang kosong
            if(model[i] == null){
                model[i] = todo;
                isFull = false;
                break;
            }
        }

        // Jika array penuh resize array menjadi 2 x lipat.

        if(isFull){
            var temp = model;
            model = new String[model.length * 2];
           for (var i = 0; i < temp.length; i++){
               model[i] = temp[i];
           }

            //Tambahkan todo ke array yang masih kosong

            for (var i = 0; i < model.length; i++){
                //Jika array masih ada yang kosong
                if(model[i] == null){
                    model[i] = todo;
                    break;
                }
            }
        }
    }

    // test add todo list;
    public static void testAddTodoList(){
        for (var i = 0; i < 100; i++){
            addTodoList("contoh todo ke " + i);
        }

        showTodoList();
    }

    /**
     * method remove todo list;
     * @param number untuk menghapus todo list;
     * @return true jika berhasil, false jika gagal
     */
    public static boolean removeTodoList(int number){
        if((number - 1) >= model.length){
            return false;
        } else if(model[number - 1] == null){
            return false;
        } else {
            for(var i = number - 1; i < model.length; i++) {
                if(i == model.length - 1){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }


    // Test remove todo list.

    public static void testRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        var result = removeTodoList(2);
        System.out.println(result);

        result = removeTodoList(5);
        System.out.println(result);

        showTodoList();
    }
}
