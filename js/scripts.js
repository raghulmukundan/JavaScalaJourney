$(document).ready(function() {
    // Load content when navigation links are clicked
    $('#navJava').on('click', function(e) {
        e.preventDefault();
        $('#indexList').load('java/index.html');
        $('#contentArea').html('<h2>Java</h2><p>Select a subsection from the left to view its content here.</p>');
    });

    $('#navScala').on('click', function(e) {
        e.preventDefault();
        $('#indexList').load('scala/index.html');
        $('#contentArea').html('<h2>Scala</h2><p>Select a subsection from the left to view its content here.</p>');
    });

    // Load content based on the index click
    $('#indexList').on('click', '.list-group-item', function(e) {
        e.preventDefault();
        var target = $(this).data('target');
        if (target) {
            $('#contentArea').load(target);
            $('.list-group-item').removeClass('active');
            $(this).addClass('active');
        }
    });
});
