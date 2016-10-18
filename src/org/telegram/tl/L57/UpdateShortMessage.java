package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class UpdateShortMessage extends TLUpdates {

    public static final int ID = 0x914fbf11;

    public int flags;
    public int id;
    public int user_id;
    public String message;
    public int pts;
    public int pts_count;
    public int date;
    public TLMessageFwdHeader fwd_from;
    public int via_bot_id;
    public int reply_to_msg_id;
    public TLVector<TLMessageEntity> entities;

    public UpdateShortMessage() {
        this.entities = new TLVector<>();
    }

    public UpdateShortMessage(int flags, int id, int user_id, String message, int pts, int pts_count, int date, TLMessageFwdHeader fwd_from, int via_bot_id, int reply_to_msg_id, TLVector<TLMessageEntity> entities) {
        this.flags = flags;
        this.id = id;
        this.user_id = user_id;
        this.message = message;
        this.pts = pts;
        this.pts_count = pts_count;
        this.date = date;
        this.fwd_from = fwd_from;
        this.via_bot_id = via_bot_id;
        this.reply_to_msg_id = reply_to_msg_id;
        this.entities = entities;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        flags = buffer.readInt();
        id = buffer.readInt();
        user_id = buffer.readInt();
        message = buffer.readString();
        pts = buffer.readInt();
        pts_count = buffer.readInt();
        date = buffer.readInt();
        if ((flags & (1 << 2)) != 0) {
            fwd_from = (TLMessageFwdHeader) buffer.readTLObject(APIContext.getInstance());
        }
        if ((flags & (1 << 11)) != 0) {
            via_bot_id = buffer.readInt();
        }
        if ((flags & (1 << 3)) != 0) {
            reply_to_msg_id = buffer.readInt();
        }
        if ((flags & (1 << 7)) != 0) {
            entities = (TLVector<TLMessageEntity>) buffer.readTLVector(TLMessageEntity.class);
        }
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        setFlags();
        serializeTo(buffer);
        return buffer;
    }

    public void setFlags() {
        if (fwd_from != null) {
            flags |= (1 << 2);
        }
        if (via_bot_id != 0) {
            flags |= (1 << 11);
        }
        if (reply_to_msg_id != 0) {
            flags |= (1 << 3);
        }
        if (entities != null) {
            flags |= (1 << 7);
        }
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(flags);
        buff.writeInt(id);
        buff.writeInt(user_id);
        buff.writeString(message);
        buff.writeInt(pts);
        buff.writeInt(pts_count);
        buff.writeInt(date);
        if ((flags & (1 << 2)) != 0) {
            buff.writeTLObject(fwd_from);
        }
        if ((flags & (1 << 11)) != 0) {
            buff.writeInt(via_bot_id);
        }
        if ((flags & (1 << 3)) != 0) {
            buff.writeInt(reply_to_msg_id);
        }
        if ((flags & (1 << 7)) != 0) {
            buff.writeTLObject(entities);
        }
    }

    public boolean is_out() {
        return (flags & (1 << 1)) != 0;
    }

    public void set_out(boolean v) {
        if (v) {
            flags |= (1 << 1);
        } else {
            flags &= ~(1 << 1);
        }
    }

    public boolean is_mentioned() {
        return (flags & (1 << 4)) != 0;
    }

    public void set_mentioned(boolean v) {
        if (v) {
            flags |= (1 << 4);
        } else {
            flags &= ~(1 << 4);
        }
    }

    public boolean is_media_unread() {
        return (flags & (1 << 5)) != 0;
    }

    public void set_media_unread(boolean v) {
        if (v) {
            flags |= (1 << 5);
        } else {
            flags &= ~(1 << 5);
        }
    }

    public boolean is_silent() {
        return (flags & (1 << 13)) != 0;
    }

    public void set_silent(boolean v) {
        if (v) {
            flags |= (1 << 13);
        } else {
            flags &= ~(1 << 13);
        }
    }

    public int getConstructor() {
        return ID;
    }
}