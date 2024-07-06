$(document).ready(function () {
    // Load content when navigation links are clicked
    $('#mainNav').on('click', '#navJava', function (e) {
        e.preventDefault();
        $('#navJava').addClass('active');
        $('#navScala').removeClass('active');
        $('#indexList').load('java/index.html', function () {
            // Highlight the "Beginner" section and load its content
            const initialTarget = $('#indexList .list-group-item[data-target="java/beginner/intro.html"]');
            $('#javaBeginner').addClass('show');
            initialTarget.addClass('active');
            $('#contentArea').load(initialTarget.data('target'));

        });
    });

    $('#mainNav').on('click', '#navScala', function (e) {
        e.preventDefault();
        $('#navScala').addClass('active');
        $('#navJava').removeClass('active');
        $('#indexList').load('scala/index.html');
        $('#contentArea').html('<h2>Scala</h2><p>Select a subsection from the left to view its content here.</p>'); 4
    });

    // Load content based on the index click
    $('#indexList').on('click', '.list-group-item', function (e) {
        e.preventDefault();
        var target = $(this).data('target');
        if (target) {
            $('#contentArea').load(target, function () {
                $('code[data-src]').each(function () {
                    var codeBlock = $(this);
                    var src = codeBlock.data('loc') + "/code/src/com/javascalajourney/" + codeBlock.data('src');
                    $.get(src, function (data) {
                        codeBlock.text(data);
                        Prism.highlightAll();
                    });
                });
                Prism.highlightAll();
                $('.copy-button').click(function () {
                    var code = $(this).siblings('pre').find('code').text();
                    var copyStatus = $(this).siblings('div .copy-status')
                    navigator.clipboard.writeText(code).then(function () {
                        copyStatus.fadeIn().delay(5000).fadeOut();
                    }, function () {
                        console.log("error copy");
                    });
                });
            });
            $('.list-group-item').removeClass('active');
            $(this).addClass('active');
        }
    });
});
