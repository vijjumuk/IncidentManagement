package com.homedepot.di.xd.efs.upload;

public enum FileType {

	LOCATION(1), LANE(2), LOADGROUP_PARM(3), VNDR_PARM(4), ROUTE(5), SCHEDULE(6), GENERIC(99);

	private int fileType;
	
	private FileType(int type) {
		fileType = type;
	}
	
	public int getFileType() {
		return fileType;
	}
	
	public static FileType getFileTypeFor(int type) {
		FileType[] types = FileType.values();
		for (int i = 0; i < types.length; i++) {
			if (types[i].getFileType() == type) {
				return types[i];
			}
		}
		return null;
	}
	
}
