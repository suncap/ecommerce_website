import { Component, OnInit } from '@angular/core';
import { Book} from '../../models/book';
import { GetbooklistserviceService } from '../../services/getbooklistservice.service';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef} from '@angular/material';
import { RemoveBookService } from '../../services/remove-book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  private selectedBook: Book;
  private checked: boolean;
  private bookList: Book[];
  private allChecked: boolean;
  private removeBookList:Book[] = new Array();

  constructor(
    private getBookListService: GetbooklistserviceService,
    private router: Router,
    public dialog: MatDialog,
    public removeBookService: RemoveBookService) { }

  onSelect(book: Book){
      this.selectedBook = book;
      this.router.navigate(['/viewBook',this.selectedBook.id]);
  }

  openDialog(book: Book){
    let dialogRef = this.dialog.open(DialogResultExampleDialog);
    dialogRef.afterClosed().subscribe(
      result =>{
        console.log(result);
        if(result == "yes"){
          this.removeBookService.removeBook(book.id).subscribe(
            res=>{
              console.log(res);
              this.getBookList();
            },
            error =>{
              console.log(error);
            }
          );
        }
      }
    )
  }

  updateRemoveBookList(checked:boolean, book: Book){
      if(checked){
        this.removeBookList.push(book);
      } else {
        this.removeBookList.splice(this.removeBookList.indexOf(book), 1);
      }
  }

  updateSelected(checked: boolean){
    if(checked){
      this.allChecked = true;
      this.removeBookList = this.bookList.slice();
    } else {
      this.allChecked = false;
      this.removeBookList = [];
    }
  }

  removeSelectedBooks(){
    let dialogRef = this.dialog.open(DialogResultExampleDialog);
    dialogRef.afterClosed().subscribe(
      result =>{
        console.log(result);
        if(result == "yes"){
          for(let book of this.removeBookList){
            this.removeBookService.removeBook(book.id).subscribe(
              res=>{
                console.log(res);
              },
              error =>{
                console.log(error);
              }
            );
          }
          location.reload();
        }
      }
    )
  }

  getBookList(){
    this.getBookListService.getBookList().subscribe(
      res => {
        console.log(res.json());
        this.bookList = res.json();
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit() {
    this.getBookList();
  }
}

@Component({
  selector: 'dialog-result-example-dialog',
  templateUrl: './dialog-result-example-dialog.html'
})
export class DialogResultExampleDialog{
  constructor(public dialogRef: MatDialogRef<DialogResultExampleDialog>){}
}
