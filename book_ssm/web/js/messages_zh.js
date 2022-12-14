(function( factory ) {
	if ( typeof define === "function" && define.amd ) {
		define( ["jquery", "../jquery.validate"], factory );
	} else {
		factory( jQuery );
	}
}(function( $ ) {

/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: ZH (Chinese, ä¸­æ–‡ (ZhÅngwÃ©n), æ±‰è¯­, æ¼¢èªž)
 */
$.extend($.validator.messages, {
	required: "è¿™æ˜¯å¿…å¡«å­—æ®µ",
	remote: "è¯·ä¿®æ­£æ­¤å­—æ®µ",
	email: "è¯·è¾“å…¥æœ‰æ•ˆçš„ç”µå­é‚®ä»¶åœ°å€",
	url: "è¯·è¾“å…¥æœ‰æ•ˆçš„ç½‘å€",
	date: "è¯·è¾“å…¥æœ‰æ•ˆçš„æ—¥æœŸ",
	dateISO: "è¯·è¾“å…¥æœ‰æ•ˆçš„æ—¥æœŸ (YYYY-MM-DD)",
	number: "è¯·è¾“å…¥æœ‰æ•ˆçš„æ•°å­—",
	digits: "åªèƒ½è¾“å…¥æ•°å­—",
	creditcard: "è¯·è¾“å…¥æœ‰æ•ˆçš„ä¿¡ç”¨å¡å·ç ",
	equalTo: "ä½ çš„è¾“å…¥ä¸ç›¸åŒ",
	extension: "è¯·è¾“å…¥æœ‰æ•ˆçš„åŽç¼€",
	maxlength: $.validator.format("æœ€å¤šå¯ä»¥è¾“å…¥ {0} ä¸ªå­—ç¬¦"),
	minlength: $.validator.format("æœ€å°‘è¦è¾“å…¥ {0} ä¸ªå­—ç¬¦"),
	rangelength: $.validator.format("è¯·è¾“å…¥é•¿åº¦åœ¨ {0} åˆ° {1} ä¹‹é—´çš„å­—ç¬¦ä¸²"),
	range: $.validator.format("è¯·è¾“å…¥èŒƒå›´åœ¨ {0} åˆ° {1} ä¹‹é—´çš„æ•°å€¼"),
	max: $.validator.format("è¯·è¾“å…¥ä¸å¤§äºŽ {0} çš„æ•°å€¼"),
	min: $.validator.format("è¯·è¾“å…¥ä¸å°äºŽ {0} çš„æ•°å€¼")
});

}));