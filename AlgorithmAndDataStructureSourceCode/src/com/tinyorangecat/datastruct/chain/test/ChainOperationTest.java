package com.tinyorangecat.datastruct.chain.test;

import com.tinyorangecat.datastruct.chain.MyChain;
import org.junit.Test;

public class ChainOperationTest {

    private MyChain buildChain()throws Exception{
        MyChain myChain = new MyChain();
        myChain.insertChain(3,0);
        myChain.insertChain(7,1);
        myChain.insertChain(9,2);
        myChain.insertChain(5,3);
        return myChain;
    }
    @Test
    public void chainInsertTest()throws Exception{
        MyChain chain = buildChain();
        chain.output();
    }

    @Test
    public void chainDeleteTest()throws Exception{
        MyChain chain = buildChain();
        chain.output();
        MyChain.Node deletedNode = chain.deleteChain(3);
        System.out.println("The deleted Node : "+deletedNode);
        chain.output();
    }

    @Test
    public void other()throws Exception{
        TheChain chain = new TheChain();
        chain.insertChain(3,0);
        chain.insertChain(7,1);
        chain.insertChain(9,2);
        chain.insertChain(5,3);
        chain.output();
        chain.insertChain(4,1);
        chain.output();
        System.out.println("Delete the chain index = 1 is : "+chain.deleteChain(1));
        chain.output();
    }

}
