var element_count = 0;

var events = {};

var get_event_id = function(element_id, event_type){
    return event_type+"_"+element_id;
};


var register_event = function(element_id, event_type, event_handler){

    events[get_event_id(element_id,event_type)] = event_handler;

};

var delete_event = function(element_id, event_type){

    delete events[get_event_id(element_id,event_type)];

};

var execute_event = function(element_id, event_type){

    var event_handler = events[get_event_id(element_id,event_type)];

    if (typeof(event_handler) === "undefined")
        return;

    event_handler();

};


function YesNoDialog(message,options){

    element_count = element_count + 1;

    var element_id = element_count;

    var element_options = $.extend({
        on_yes: function(){},
        on_no: function(){}
    }, typeof(options) === "undefined" ? {} : options);

    register_event(element_id, "on_yes", element_options.on_yes);
    register_event(element_id, "on_no", element_options.on_no);

    this.show = function(){

        yes_no_dialog_bridge.showDialog(message,element_id);

    };



}