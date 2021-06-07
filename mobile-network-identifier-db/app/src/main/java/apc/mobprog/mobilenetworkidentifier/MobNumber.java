package apc.mobprog.mobilenetworkidentifier;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mobileNumbers")
public class MobNumber {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "mobileNumberId")
    private int id;

    @ColumnInfo(name = "mobileNumber")
    private String mobNumPrefix;
    private String mobileNetwork;

    public MobNumber(String mobNumPrefix, String mobileNetwork) {
        this.id = id;
        this.mobNumPrefix = mobNumPrefix;
        this.mobileNetwork = mobileNetwork;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobNumPrefix() {
        return mobNumPrefix;
    }

    /* Unused method
    public void setMobNumPrefix(String mobNumPrefix) {
        this.mobNumPrefix = mobNumPrefix;
    }
    */

    public String getMobileNetwork() {
        return mobileNetwork.toUpperCase();
    }

    /* Unused method
    public void setMobileNetwork(String mobileNetwork) {
        this.mobileNetwork = mobileNetwork.toUpperCase();
    }
   */
}