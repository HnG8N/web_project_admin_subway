  const ctx = document.getElementById('myChart');

  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
      datasets: [
    	{
	        label: '전년도',
	        data: [12, 19, 3, 5, 2, 3],
	        backgroundColor: 'rgba(54, 162, 235, 0.7)',
	        borderColor: 'rgba(54, 162, 235, 1)',
	        borderWidth: 1
    	},
        {
	        label: '이번년도',  // 두 번째 데이터셋의 이름
			data: [5, 10, 8, 12, 6, 9],  // 두 번째 데이터셋의 데이터
			backgroundColor: 'rgba(153, 255, 153, 0.7)',  // 두 번째 데이터셋의 배경색
			borderColor: 'rgba(153, 255, 153, 1)',  // 두 번째 데이터셋의 테두리 색
			borderWidth: 1
        }
      ]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
