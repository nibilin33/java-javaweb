/*
Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';

	config.filebrowserUploadUrl='servlet/SimpleUploader?Type=File';   
	 config.filebrowserImageUploadUrl='servlet/SimpleUploader?Type=Image';   
	 config.filebrowserFlashUploadUrl='servlet/SimpleUploader?Type=Flash';
	 config.image_previewText=' '; 
};
