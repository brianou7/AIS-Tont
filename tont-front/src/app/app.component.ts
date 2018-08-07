import { Component } from '@angular/core';
import { BirdsService } from './birds.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [BirdsService]
})
export class AppComponent {
  title = 'Birds';
  subtitle = 'Save a new bird';
  is_update = false;

  new_bird = {
    code: "",
    common_name: "",
    scientific_name: ""
  };

  birds = [];

  // birds = [
  //     {
	// 	code: "B1",
	// 	common_name: "Common bird 1",
	// 	scientific_name: "Common bird 1"
	// },
	// {
	// 	code: "B3",
	// 	common_name: "Common bird 3",
	// 	scientific_name: "Common bird 3"
	// }
  // ];

  constructor(private service:BirdsService){
      this.birds = service.getBirds();
  }

  alertMe(value){
      alert(value);
  };

  saveBird(){
      this.service.saveBird(this.new_bird, this.is_update);

      if (!this.is_update){
          this.birds.push(Object.assign({}, this.new_bird));
      }else{
          this.is_update = false;
      }

      this.cleanNewBird();
  }

  selectBird(bird){
      this.new_bird = bird;
      this.is_update = true;
  }

  deleteBird(bird){
      const index:number = this.birds.indexOf(bird);

      if (index !== -1){
          this.birds.splice(index, 1);
      }
  }

  cleanNewBird(){
      this.new_bird = {
        code: '',
        common_name: '',
        scientific_name: ''
      }
  }
}
