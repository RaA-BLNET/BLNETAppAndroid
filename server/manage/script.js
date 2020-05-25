$("#btnchngpwd").on('click', function(event){
var ddown = $("#dropdownid1");
var ddowns = $("#dropdownid1 option:selected");
if (ddowns.val() === 'plsselect') {
ddown.css('border-color', 'red');
var error_free = false;
} else {
ddown.css('border-color', 'initial');
var error_free = true;
}
if (!error_free){
event.preventDefault(); 
}
});
$("#btnchng").on('click', function(event){
var ddown = $("#dropdown");
var ddowns = $("#dropdown option:selected");
if (ddowns.val() === 'plsselect') {
ddown.css('border-color', 'red');
var error_free = false;
} else {
ddown.css('border-color', 'initial');
var error_free = true;
}
if (!error_free){
event.preventDefault(); 
}
});
$("#btnchng").on('click', function(event){
var ddown = $("#selectid");
var ddowns = $("#selectid option:selected");
if (ddowns.val() === 'plsselect') {
ddown.css('border-color', 'red');
var error_free = false;
} else {
ddown.css('border-color', 'initial');
var error_free = true;
}
if (!error_free){
event.preventDefault(); 
}
});
$("#btndeleteur").on('click', function(event){
var ddown = $("#deleteemailur");
var ddowns = $("#deleteemailur option:selected");
if (ddowns.val() === 'plsselect') {
ddown.css('border-color', 'red');
var error_free = false;
} else {
ddown.css('border-color', 'initial');
var error_free = true;
}
if (!error_free){
event.preventDefault(); 
}
});
$("#btndelete").on('click', function(event){
var ddown = $("#deleteemail");
var ddowns = $("#deleteemail option:selected");
if (ddowns.val() === 'plsselect') {
ddown.css('border-color', 'red');
var error_free = false;
} else {
ddown.css('border-color', 'initial');
var error_free = true;
}
if (!error_free){
event.preventDefault(); 
}
});
$("#btnadd").on('click', function(event){
var ddown = $("#email");
var ddowns = $("#email option:selected");
if (ddowns.val() === 'plsselect') {
ddown.css('border-color', 'red');
var error_free = false;
} else {
ddown.css('border-color', 'initial');
var error_free = true;
}
if (!error_free){
event.preventDefault(); 
}
});