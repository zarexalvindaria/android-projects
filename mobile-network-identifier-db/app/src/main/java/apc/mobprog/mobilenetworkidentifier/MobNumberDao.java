package apc.mobprog.mobilenetworkidentifier;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MobNumberDao {

    @Insert
    void insertMobileNumber(MobNumber mobNumber);

    @Query("SELECT * FROM mobileNumbers WHERE mobileNumber = :number")
    List<MobNumber> findMobNumber(String number);

    @Query("DELETE FROM mobileNumbers WHERE mobileNumber = :number")
    void deleteMobileNumber(String number);

    @Query("DELETE FROM mobileNumbers")
    void deleteDatabase();

    @Query("SELECT * FROM mobileNumbers")
    LiveData<List<MobNumber>> getAllMobileNumbers();

}
