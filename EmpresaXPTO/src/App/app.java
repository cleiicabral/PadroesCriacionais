
package App;

import AbstractFactory.FabricaTipTop;
import AbstractFactory.RedeTipTop;
import AbstractFactory.RedesFactory;

public class app {
     public static void main(String [] args){
        
        RedeTipTop r1;
        
        RedesFactory f1=new FabricaTipTop();
        
        r1= (RedeTipTop) f1.criar();
       
        r1.enviaMensagem();
        r1.criarPostFeed();
    }
}
