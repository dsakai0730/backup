alert("Hello JavaScript:D");


function hoge(res) {
	console.log(res);
	for (var i=0, n=res.items.length; i<n; i++) {
		var item = res.items[i];
		var a = document.createElement('a');
		a.href = item.volumeInfo.previewLink;

		var img = document.createElement('img');
		img.src = item.volumeInfo.imageLinks.thumbnail;

		a.appendChild(img);
		document.body.appendChild(a);
	}

	"https://www.googleapis.com/books/v1/volumes?q=harry+potter&callback=hoge"
}

