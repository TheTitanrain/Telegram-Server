package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class InputEncryptedFileLocation extends TLInputFileLocation {

    public static final int ID = 0xf5235d55;

    public long id;
    public long access_hash;

    public InputEncryptedFileLocation() {
    }

    public InputEncryptedFileLocation(long id, long access_hash) {
        this.id = id;
        this.access_hash = access_hash;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        id = buffer.readLong();
        access_hash = buffer.readLong();
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
        buff.writeLong(id);
        buff.writeLong(access_hash);
    }


    public int getConstructor() {
        return ID;
    }
}