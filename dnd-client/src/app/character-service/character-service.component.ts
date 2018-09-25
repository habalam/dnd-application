import {Component, Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Race, Subrace} from "../content-root/content-root.component";

@Component({
  selector: 'app-character-service',
  templateUrl: './character-service.component.html',
  styleUrls: ['./character-service.component.scss']
})
@Injectable()
export class CharacterServiceComponent implements OnInit {

  constructor(private http: HttpClient) { }

  getRaces() {
    return this.http.get<Array<Race>>('http://localhost:8080/races');
  }

  getSubraces(id: number) {
    return this.http.get<Array<Subrace>>('http://localhost:8080/subraces?raceId=' + id);
  }

  ngOnInit() {
  }

}
