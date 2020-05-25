var ss = SpreadsheetApp.openByUrl("SHEETLINKHIEREINFÜGEN");

var sheet = ss.getSheetByName('Formularantworten'); // be very careful ... it is the sheet name .. so it should match


function doPost(e){
var action = e.parameter.action;

if(action == 'addItem'){
return addItem(e);

}

}





function addItem(e){

var date = new Date();

var datefromuser = e.parameter.datum;

var fach = e.parameter.fach;

var thema = e.parameter.themaPruefung;

var notentyp = e.parameter.notenTyp;

var note = e.parameter.note;

var begruendung = e.parameter.begruendung;

sheet.appendRow([date,datefromuser,fach,thema,notentyp,note,begruendung]);

return ContentService.createTextOutput("Success").setMimeType(ContentService.MimeType.TEXT);



}