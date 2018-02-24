$(document).ready(function() {
	setSubraces();

	$('#race').change(
		function() {
			setSubraces();
		}
	)
	$('#subrace').change(
		function() {
			setSubracePhysiognomy();
		}
	);
});

function setSubraces() {
	$.getJSON(
		"http://localhost:8080/subraces",
		{raceId: $('#race').val()},
		function(data) {
            var html;
            for (i = 0; i < data.length; i += 1) {
                //TODO zbavit sa tohto - vytvorit priamo pouzitelny JSON
                var subrace = $.parseJSON(data[i]);
                html += '<option value="' + subrace.id + '">' + subrace.currentLocale.name + '</option>';
            }
            $('#subrace').html(html);
            setSubracePhysiognomy();
		}
	);
};

function setSubracePhysiognomy() {
	$.getJSON(
		"http://localhost:8080/subrace/physiognomy",
		{subraceId: $('#subrace').val()},
		function(data) {
			var middleHeightModifierValue = Math.round(((data.heightModifier+1)/2)*data.heightModifierMultiplier);
			var maxHeightModifierValue = data.heightModifier*data.heightModifierMultiplier;
			var minHeightModifierValue = data.heightModifierMultiplier;
			var minWeightModifierValue = data.heightModifierMultiplier*data.weightModifierMultiplier;
			var maxWeightModifierValue = maxHeightModifierValue*(data.weightModifier*data.weightModifierMultiplier);
			var middleWeightModifierValue = Math.round((((data.heightModifier+1)/2)*data.heightModifierMultiplier)*(((data.weightModifier+1)/2)*data.weightModifierMultiplier));
			var maxHeight = data.baseHeight + maxHeightModifierValue;
			var minHeight = data.baseHeight + minHeightModifierValue;
			var middleHeight = data.baseHeight + middleHeightModifierValue;
			var maxWeight = data.baseWeight + maxWeightModifierValue;
			var minWeight = data.baseWeight + minWeightModifierValue;
			var middleWeight = data.baseWeight + middleWeightModifierValue;
        	var heightFeetsHtml;
        	for (i = Math.floor(minHeight/12); i <= Math.floor(maxHeight/12); i += 1) {
                heightFeetsHtml += '<option value="' + i + '">' + i + '</option>';
        	}
            $('#feets').html(heightFeetsHtml);
            $('#feets').val(Math.floor(middleHeight/12));

            var heightInchesHtml;
            for (i = 0; i <= 11; i += 1) {
                heightInchesHtml += '<option value="' + i + '">' + i + '</option>';
            }
            $('#inches').html(heightInchesHtml);
            $('#inches').val(middleHeight%12)
            
            var weightHtml;
            for(i = minWeight; i <= maxWeight; i += 1) {
                weightHtml += '<option value="' + i + '">' + i + '</option>';
            }
            $('#weight').html(weightHtml);
            $('#weight').val(middleWeight);

            //TODO add function to set max/min inch value in inch height combobox
		}
	);
}