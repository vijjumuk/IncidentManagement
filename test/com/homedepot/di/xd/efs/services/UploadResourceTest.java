package com.homedepot.di.xd.efs.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.sun.jersey.core.header.FormDataContentDisposition;

/**
 */
public class UploadResourceTest {

	/**
	 * Method testLaneUploadFile.
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLaneUploadFile() throws Exception {

		UploadResource resource = new UploadResource();

		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/Lane_Upload_Valid.csv"));

		FormDataContentDisposition fileDetail = new FormDataContentDisposition(
				"Lane");
		String userId = "SXV8609";
		String fileType = "2";
		resource.uploadFile(uploadedInputStream, fileDetail, userId, fileType);
	}

	/**
	 * Method testRouteUploadFile.
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRouteUploadFile() throws Exception {

		UploadResource resource = new UploadResource();

		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/RouteUpload_validheader.csv"));

		FormDataContentDisposition fileDetail = new FormDataContentDisposition(
				"Route");
		String userId = "lpb5551";
		String fileType = "5";
		resource.uploadFile(uploadedInputStream, fileDetail, userId, fileType);
	}

}
