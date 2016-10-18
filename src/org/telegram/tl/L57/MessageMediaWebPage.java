package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class MessageMediaWebPage extends TLMessageMedia {

    public static final int ID = 0xa32dd600;

    public TLWebPage webpage;

    public MessageMediaWebPage() {
    }

    public MessageMediaWebPage(TLWebPage webpage) {
        this.webpage = webpage;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        webpage = (TLWebPage) buffer.readTLObject(APIContext.getInstance());
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
        buff.writeTLObject(webpage);
    }


    public int getConstructor() {
        return ID;
    }
}