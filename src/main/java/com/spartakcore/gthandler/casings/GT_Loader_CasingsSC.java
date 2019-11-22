package com.spartakcore.gthandler.casings;

public class GT_Loader_CasingsSC implements Runnable {
    @Override
    public void run(){
        GT_Container_CasingsSC.sBlockCasingsSC = new GT_Block_CasingsSC();
    }
}
