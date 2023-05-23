package nhatph29877.fpoly.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import nhatph29877.fpoly.duanmau.Model.PhieuMuon;
import nhatph29877.fpoly.duanmau.databace.DBhelper;


public class PhieuMuonDAO {
    DBhelper dbHelper;

    public PhieuMuonDAO(Context context) {
        dbHelper = new DBhelper(context);
    }

    public ArrayList<PhieuMuon> GetDSPM() {
        ArrayList<PhieuMuon> listpm = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM phieumuon", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                PhieuMuon phieuMuon = new PhieuMuon();
                phieuMuon.setMapm(Integer.parseInt(cursor.getString(0)));
                phieuMuon.setNgaythue(cursor.getString(1));
                phieuMuon.setTrangthai(cursor.getString(2));
                phieuMuon.setTentv(cursor.getString(3));
                phieuMuon.setTens(cursor.getString(4));
                phieuMuon.setGiathue(Integer.parseInt(cursor.getString(5)));
                listpm.add(phieuMuon);
            } while (cursor.moveToNext());
        }
        return listpm;

    }

    public long Thempm(PhieuMuon phieuMuon) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ngaythue", phieuMuon.getNgaythue());
        contentValues.put("trangthai", phieuMuon.getTrangthai());
        contentValues.put("TenTV", phieuMuon.getTentv());
        contentValues.put("TenS", phieuMuon.getTens());
        contentValues.put("GiathueS", phieuMuon.getGiathue());

        return sqLiteDatabase.insert("phieumuon", null, contentValues);

    }

    public long Suapm(PhieuMuon phieuMuon) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ngaythue", phieuMuon.getNgaythue());
        contentValues.put("trangthai", phieuMuon.getTrangthai());
        contentValues.put("TenTV", phieuMuon.getTentv());
        contentValues.put("TenS", phieuMuon.getTens());
        contentValues.put("GiathueS", phieuMuon.getGiathue());

        return sqLiteDatabase.update("phieumuon", contentValues, "MaPM = ?", new String[]{String.valueOf(phieuMuon.getMapm())});
    }

    public long Xoapm(int  mapm) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        return sqLiteDatabase.delete("phieumuon", "MaPM = ?", new String[]{String.valueOf(mapm)});
    }

}