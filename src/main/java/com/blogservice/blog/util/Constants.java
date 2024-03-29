package com.blogservice.blog.util;

public class Constants {
	public interface ErrorCodes {
		public static final int USER_NOT_FOUND = 250;
		public static final int WRONG_PASSWORD = 2560;
		public static final int FILE_UPLOAD_ERROR = 2500;
		public static final int POST_UPLOAD_ERROR = 2501;
		public static final int TRANSACTION_FAILED = 300;
		public static final int TRANSACTION_SUCCESS = 200;
		public static final int USER_EXIST = 2015;
		public static final int POST_NOT_FOUND= 2016;
	}
	public interface SEQUENCE{
		public static final String POST_SEQ = "POST_SEQ";
	}
}
