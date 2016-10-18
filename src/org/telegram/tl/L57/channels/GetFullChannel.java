package org.telegram.tl.L57.channels;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class GetFullChannel extends TLObject {

    public static final int ID = 0x8736a09;

    public TLInputChannel channel;

    public GetFullChannel() {
    }

    public GetFullChannel(TLInputChannel channel) {
        this.channel = channel;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        channel = (TLInputChannel) buffer.readTLObject(APIContext.getInstance());
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeTLObject(channel);
    }


    public int getConstructor() {
        return ID;
    }
}