package apc.mobprog.mobilenetworkidentifier;

import androidx.lifecycle.LiveData;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MobNumberRepository {

    private MutableLiveData<List<MobNumber>> searchResults =
            new MutableLiveData<>();
    private LiveData<List<MobNumber>> allMobileNumbers;
    private MobNumberDao mobNumberDao;

    public MobNumberRepository(Application application) {
        MobNumberRoomDatabase db;
        db = MobNumberRoomDatabase.getDatabase(application);
        mobNumberDao = db.mobNumberDao();
        allMobileNumbers = mobNumberDao.getAllMobileNumbers();
    }

    private void asyncFinished(List<MobNumber> results) {
        searchResults.setValue(results);
    }

    private static class QueryAsyncTask extends
            AsyncTask<String, Void, List<MobNumber>> {
        private MobNumberDao asyncTaskDao;

        private MobNumberRepository delegate = null;

        QueryAsyncTask(MobNumberDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected List<MobNumber> doInBackground(final String... params) {
            return asyncTaskDao.findMobNumber(params[0]);
        }

        @Override
        protected void onPostExecute(List<MobNumber> result) {
            delegate.asyncFinished(result);
        }
    }

    private static class InsertAsyncTask extends AsyncTask<MobNumber, Void, Void> {
        private MobNumberDao asyncTaskDao;

        InsertAsyncTask(MobNumberDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final MobNumber... params) {
            asyncTaskDao.insertMobileNumber(params[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<String, Void, Void> {
        private MobNumberDao asyncTaskDao;

        DeleteAsyncTask(MobNumberDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final String... params) {
            asyncTaskDao.deleteMobileNumber(params[0]);
            return null;
        }
    }

    private static class DeleteDb extends AsyncTask<String, Void, Void> {
        private MobNumberDao asyncTaskDao;

        DeleteDb(MobNumberDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final String... params) {
            asyncTaskDao.deleteDatabase();
            return null;
        }
    }

    public void deleteDatabase() {
        DeleteDb task = new DeleteDb(mobNumberDao);
        task.execute();
    }

    public void insertMobileNumber(MobNumber newmobilenumber) {
        InsertAsyncTask task = new InsertAsyncTask(mobNumberDao);
        task.execute(newmobilenumber);
    }

    public void deleteMobileNumber(String name) {
        DeleteAsyncTask task = new DeleteAsyncTask(mobNumberDao);
        task.execute(name);
    }

    public void findMobileNumber(String name) {
        QueryAsyncTask task = new QueryAsyncTask(mobNumberDao);
        task.delegate = this;
        task.execute(name);
    }


    public LiveData<List<MobNumber>> getAllMobileNumbers() {
        return allMobileNumbers;
    }

    public MutableLiveData<List<MobNumber>> getSearchResults() {
        return searchResults;
    }
}