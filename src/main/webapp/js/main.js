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

				var options = $('#leds option:selected');
				var optionValues = $.map(options, function(option) {
					return option.value;
				});

				if (optionValues.indexOf("all") == -1) {
					for (i = 0; i < optionValues.length; i++) {
						setLedColor(optionValues[i], hex);
					}
				} else {
					setAllLedsColor(hex);
				}

			}
		}
	}).keyup(function() {
		$(this).colpickSetColor(this.value);
	});
});

function setLedColor(id, hex) {
	if (hex != $('#previousColor').val()) {
		$.ajax({
			url : 'api/leds/' + id + '/' + hex,
			type : 'PUT',
			success : function(result) {
				// Do nothing!
			}
		});
		$('#previousColor').val(hex);
	}
}

function setAllLedsColor(hex) {
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
