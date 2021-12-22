import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'keys'
})
export class KeysPipePipe implements PipeTransform {

  transform(value, args: string[]): any {
    const keys = [];
    // tslint:disable-next-line: forin
    for (const key in value) {
      keys.push({key, value: value[key]});
    }
    return keys;
  }

}
