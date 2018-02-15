import { Injectable } from '@angular/core';

@Injectable()
export class UploadFileService {

  filesToUpload: Array<File>;

  constructor() {
    this.filesToUpload = [];
  }

  uploadFile(bookId: number){
    this.makeFileRequest("http://localhost:8181/book/add/image?id="+bookId,
      [],
      this.filesToUpload
    );
  }

  fileChangeEvent(filesInput: any){
    this.filesToUpload = <Array<File>> filesInput.target.files;
  }

  makeFileRequest(url: string, params: Array<string>, files:Array<File>){
    return new Promise((resolve, reject)=>{
      var formData:any = new FormData();
      var xhr = new XMLHttpRequest();
      for(var i=0; i<files.length; i++){
        formData.append("uploads[]", files[i], files[i].name);
      }

      xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
          if(xhr.status == 200){
            console.log("uploaded successfully");
          } else {
            reject(xhr.response);
          }
        }
      }

      xhr.open("POST", url, true);
      xhr.setRequestHeader("x-auth-token", localStorage.getItem("xAuthToken"));
      xhr.send(formData);
    });
  }
}
