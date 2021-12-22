import { IpListAsn } from './ip-list-asn';

export class IpListResult {
    ip: string;
    registry: string;
    countrycode: string;
    countryname: string;
    asn?: IpListAsn;
    city: string;
    spam: boolean;
    tor: boolean;
}
