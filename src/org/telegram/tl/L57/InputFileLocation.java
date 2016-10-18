package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class InputFileLocation extends TLInputFileLocation {

    public static final int ID = 0x14637196;

    public long volume_id;
    public int local_id;
    public long secret;

    public InputFileLocation() {
    }

    public InputFileLocation(long volume_id, int local_id, long secret) {
        this.volume_id = volume_id;
        this.local_id = local_id;
        this.secret = secret;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        volume_id = buffer.readLong();
        local_id = buffer.readInt();
        secret = buffer.readLong();
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
        buff.writeLong(volume_id);
        buff.writeInt(local_id);
        buff.writeLong(secret);
    }


    public int getConstructor() {
        return ID;
    }
}