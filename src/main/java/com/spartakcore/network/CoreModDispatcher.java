package com.spartakcore.network;

import com.spartakcore.lib.Refstrings;
import com.spartakcore.network.msg.CTTClientSyncMessage;
import eu.usrv.yamcore.network.PacketDispatcher;

public class CoreModDispatcher extends PacketDispatcher
{

    public CoreModDispatcher()
    {
        super(Refstrings.MODID);
    }

    @Override
    public void registerPackets()
    {
        registerMessage(CTTClientSyncMessage.CTTClientSyncMessageHandler.class, CTTClientSyncMessage.class);
    }
}