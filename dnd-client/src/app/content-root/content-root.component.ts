import {Component, HostListener, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CharacterServiceComponent} from "../character-service/character-service.component";
import {debounceTime, filter, takeWhile} from "rxjs/operators";

@Component({
  selector: 'app-content-root',
  templateUrl: './content-root.component.html',
  styleUrls: ['./content-root.component.scss'],
  host: {'id': 'new-character-base-info'}
})
export class ContentRootComponent implements OnInit, OnDestroy {

  newCharacterForm: FormGroup;
  genders: Array<{text: string, value: string}> = [
    {text: 'Muž', value: 'male'},
    {text: 'Žena', value: 'female'}
  ];
  races: Array<Race>;
  currentRace: Race;
  subraces: Array<Subrace>;

  alive: boolean = true;

  constructor(fb: FormBuilder, private characterService: CharacterServiceComponent) {
    this.newCharacterForm = fb.group({
      'name': ['', Validators.compose([Validators.required, Validators.minLength(2)])],
      'gender': [this.genders[0].value],
      'race': [ '', Validators.required],
      'subrace': ['']
    });

    this.newCharacterForm.controls['race'].valueChanges.pipe(
      filter(value => this.newCharacterForm.controls['race'].valid),
      debounceTime(500),
      takeWhile(() => this.alive)
    ).subscribe(data => {
      this.characterService.getSubraces(1).subscribe(data => {
        this.subraces = data as Array<Subrace>;
      });
    });
  }

  @HostListener('document:keypress', ['$event'])
  handleKeybordEvent(event: KeyboardEvent) {
    if (event.code === 'Enter') {
      console.log(this.newCharacterForm.controls['name'].value);
      console.log(this.newCharacterForm.controls['gender'].value);
      console.log(this.newCharacterForm.controls['race'].value);
      console.log(this.races[0].currentLocale.alignment);
    }
  }

  ngOnInit() {
    this.characterService.getRaces().subscribe(data => {
      this.races = data as Array<Race>;
      this.currentRace = this.races[0];
      this.characterService.getSubraces(1).subscribe(data => {
        this.subraces = data as Array<Subrace>;
        console.log(this.subraces);
      });
    });
  }

  ngOnDestroy() {
    this.alive = false;
  }
}

export class Race {
  id: number;
  currentLocale: RaceLocale;
}

class RaceLocale {
  name: string;
  age: string;
  alignment: string;
  size: string;
  description: string;
}

export class Subrace {
  id: number;
  currentLocale: SubraceLocale;
}

class SubraceLocale {
  name: string;
  description: string;
}
