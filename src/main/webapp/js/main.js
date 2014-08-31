$(document).ready(function() {
	$('#picker').colpick({
		flat : true,
		layout : 'hex',
		submit : 0,
		livePreview : false,
		onChange : function(hsb, hex, rgb, el, bySetColor) {
			// Send request only if the color was set using the picker, and not
			// the colpickSetColor function.
			if (!bySetColor) {
				if (hex != $('#previousColor').val()) {
					$.ajax({
						url : 'api/leds/' + hex,
						type : 'PUT',
						success : function(result) {
							// Do nothing!
						}
					});
					$('#previousColor').val(hex);
				}
			}
		}
	}).keyup(function() {
		$(this).colpickSetColor(this.value);
	});
});
