$(document).ready(function() {
var images=[];
$('.image-confirm-delete').on('click',function (e) {
    e.preventDefault();
    var id = $(this).data('id');
    var name=$(this).data('name');

    images.push(name);

    $('#removeImages').val(images);
    $('#imageIndex'+id).hide();
});

$('.confirm-delete').on('click',function (e) {
    e.preventDefault();
    var id = $(this).data('id');
    var name=$(this).data('name');
    $('#modal-name').html(name);
    $('#idModalLink').attr('href','/deleteUser/'+id);
    $('#myModal').modal();

});
});
