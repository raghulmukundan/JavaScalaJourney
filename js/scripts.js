$(document).ready(function() {
    // Load content when navigation links are clicked
    $('#mainNav').on('click', '#navJava', function(e) {
        e.preventDefault();
        $('#navJava').addClass('active');
        $('#navScala').removeClass('active');
        $('#indexList').load('java/index.html', function() {
            // Highlight the "Beginner" section and load its content
            const initialTarget = $('#indexList .list-group-item[data-target="java/beginner/intro.html"]');
            $('#javaBeginner').addClass('show');
            initialTarget.addClass('active');
            $('#contentArea').load(initialTarget.data('target'));
        });
    });

    $('#mainNav').on('click', '#navScala', function(e) {
        e.preventDefault();
        $('#navScala').addClass('active');
        $('#navJava').removeClass('active');
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
