import { Component, OnInit } from '@angular/core';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Book} from '../../models/book';
import { GetBookService } from '../../services/get-book.service';
import { EditBootService } from '../../services/edit-boot.service';
import { UploadFileService } from '../../services/upload-file.service';

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {

  private bookId:number;
  private book: Book = new Book();
  private bookUpdated: boolean = false;

  constructor(private uploadImageService:UploadFileService,
  private editBookService: EditBootService,
  private getBookService: GetBookService,
  private route: ActivatedRoute,
  private router: Router) { }

  onSubmit(){
    this.editBookService.sendBook(this.book).subscribe(
      data => {
        this.uploadImageService.modify(
            JSON.parse(JSON.parse(JSON.stringify(data))._data)
          );
          this.bookUpdated = true;
        }, error => {
          console.log(error);
        }
    );
  }

  ngOnInit() {
    this.route.params.forEach((params:Params)=>{
      this.bookId = Number.parseInt(params['id']);
    });

    this.getBookService.getBook(this.bookId).subscribe(
      res=> {
        this.book = res.json();
      },
      error => {
        console.log(error);
      }
    );
  }

}
