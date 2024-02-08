 $(document).ready(function() {			
    $("#mnname").keyup(function() {
        var replace_text = $(this).val().replace(/[^ㄱ-ㅎㅏ-ㅣ가-힣&\s]/g, '');
        $(this).val(replace_text);
    });
    $("#mnengname").keyup(function() {
        var replace_text = $(this).val().replace(/[^a-zA-Z& .™]/g, '');
        $(this).val(replace_text);
    });
    $("#mnprice").keyup(function() {
        var replace_text = $(this).val().replace(/[^-0-9]/g, '');
        $(this).val(replace_text);
    });
    $('#product').validate({
        rules: {
            mnctg: {
                required: true,
                maxlength: 10
            },
            mnname: {
                required: true,
                maxlength: 30
            },
            mnengname: {
                required: true,
                maxlength: 50
            },
            mninfo: {
                required: true
            },
            mnprice: {
                required: true,
                maxlength: 5
            },
        },
        messages: {
            mnctg: {
                required: "카테고리를 입력하세요.",
                maxlength: "10자 이하로 입력해주세요."
            },
            mnname: {
                required: "이름을 입력하세요.",
                maxlength: "30자 이하로 입력해주세요."
            },
            mnengname: {
                required: "영문명을 입력하세요.",
                maxlength: "50자 이하로 입력해주세요."
            },
            mninfo: {
                required: "상세 정보를 입력하세요."
            },
            mnprice: {
                required: "가격을 입력하세요.",
                maxlength: "10만원 미만으로 입력해주세요."
            },
        }
    });
    $('#product').submit(function(event) {
    // 이미지 파일이 선택되었는지 확인
	    let imgElement = document.getElementById('img').onload;
	    let mnimg = $('#mnimg').val();
	    //alert(!imgElement)
	    //alert(!mnimg)
	    if (!imgElement && !mnimg) {		// 이미지가 선택되지 않았고 이미지가 출력되지 않았을 경우 제출 막고 메시지 출력
	        event.preventDefault(); // 폼 제출 방지
	        alert('이미지를 등록해주세요.');
	    }
	});
});
// 이미지를 미리보기하는 함수
function previewImage(event) {
    // HTML에서 이미지를 표시할 img 요소를 가져옵니다.
    let imgPreview = document.getElementById('imgPreview');

    // 파일 입력 필드에서 선택한 파일을 가져옵니다.
    let file = event.target.files[0];

    // 파일이 선택된 경우
    if (file) {
        // 선택한 파일의 URL을 생성하여 이미지를 표시합니다.
        imgPreview.src = URL.createObjectURL(file);
    } else {
        // 파일 선택이 취소되었을 때, 이미지를 지웁니다.
        imgPreview.src = '';
    }
}