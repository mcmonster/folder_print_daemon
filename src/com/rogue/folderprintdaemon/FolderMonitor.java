package com.rogue.folderprintdaemon;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.FileObserver;
import android.support.v4.print.PrintHelper;

public class FolderMonitor extends FileObserver {

	public FolderMonitor(String path) {
		super(path, CREATE);
	}

	@Override
	public void onEvent(int event, String path) {
		// Print a test image
		PrintHelper photoPrinter = new PrintHelper(MainActivity.getInstance());
		photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
		
		Bitmap bitmap = BitmapFactory.decodeFile(path);
		photoPrinter.printBitmap("test print", bitmap);
	}
}
